package com.database.jpa.hibernate.demo.rest;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
class MyFilter extends GenericFilterBean {

  private final Tracer tracer;

  MyFilter(Tracer tracer) {
    this.tracer = tracer;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    Span currentSpan = this.tracer.currentSpan();
    if (currentSpan == null) {
      chain.doFilter(request, response);
      return;
    }
    // for readability we're returning trace id in a hex form
    ((HttpServletResponse) response).addHeader("ZIPKIN-TRACE-ID",
        currentSpan.context().traceId());
    // we can also add some custom tags
    currentSpan.tag("custom", "tag");
    System.out.println("responseHeaders");
    chain.doFilter(request, response);
  }

}
