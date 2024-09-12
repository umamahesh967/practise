package com.database.jpa.hibernate.demo.springConcepts;

/**
 *
 * 4 Http Methods
 *
 * @GET -(Safe for making multiple/repeatable calls)
 * Read only methods. Even if we call multiple times nothing changes on server.
 * Even if there is duplicate GET request, it doesn't cause any side effects because we are not
 * changing anything on the server side.
 *
 * @POST -(Not a safe method to make multiple/repeatable calls)
 * Each and every time we make post call we create a single record. So if there are multiple/repeatable
 * calls, we will create multiple records which is not safe.
 *
 * @PUT -(Safe for making multiple/repeatable calls)
 * Even if there are duplicate requests for put method, whatever changes are made we update them in
 * the 1st request. From 2nd request since we are updating the same record with same content it will not
 * have any side effects on server side.
 *
 * @DELETE -(Safe for making multiple/repeatable calls)
 * Even if there is multiple request for delete. We will delete the record in the first request.
 * Even though we don't have same record to delete from 2nd request onwards. We will not have
 * any side effects on the server side.
 *
 * @Idempotence is the property of certain operations in mathematics and computer science whereby
 * they can be applied multiple times without changing the result beyond the initial application.
 *
 * Idempotent methods(Safely repeatable methods)
 * @GET, @PUT, @DELETE
 *
 * Non Idempotent Method(Non Safe repeatable methods)
 * @POST
 *
 * https://www.linkedin.com/posts/akshaymarch7_http-methods-interview-questions-ugcPost-6753304093541834752-KeSr/
 * 
 * https://www.youtube.com/watch?v=rhTkRK53XdQ
 *
 * https://www.youtube.com/watch?v=guYMSP7JVTA
 */
public class HttpMethodIdempotence
{
}
