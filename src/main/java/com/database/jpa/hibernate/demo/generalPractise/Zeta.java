package com.database.jpa.hibernate.demo.generalPractise;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Zeta
{
    public static void main (String[] args)throws IOException
    {
        String path = "";
        System.out.println(path.replace("^/|/$", ""));
        System.out.println();

        String ids[] = {"1","41","512","65","564"};
            String firstNames[] = {"Kisame", "Jtvw", "Hashirama", "Minato", "VxgS"};
            String lastNames[] = {"Hoshigaki", "Uchiha", "UYve", "HRpf", "Fgvy"};
            String cities[] = {"Uttarakhand", "Kerala", "Punjab", "Chhattisgarh", "Tripura"};
            String cityIds[] = {"28","13","21","5","26"};
            String parameters[] = {"firstName=Kisame\nlastName=Hoshigaki\ncity=Uttarakhand",
                    "lastName=Uchiha\ncity=Kerala",
                    "firstName=Hashirama\ncity=Punjab",
                    "firstName=Minato",
                    "city=Tripura"};

        //    		InputStream inputStream = new ByteArrayInputStream();
//      //    		InputStream inputStreamReference = new ByteArrayInputStream(String.format(parameters, firstNames[i],lastNames[i],cities[i]).getBytes());
        String body = parameters[0];
        InputStream requestIS = new ByteArrayInputStream(body.getBytes());



//        public Node costructBT(Node root, int k)
//        {
//            Queue<Node> queue = new Linkedlist<>();
//            if(root == null) return new Node(k);
//            queue.add(root);
//
//            while(!queue.isEmpty)
//            {
//                Node temp = queue.poll();
//
//                if(temp.left == null)
//                {
//                    temp.left = new Node(k);
//                    return root;
//                }
//                if(temp.right == null)
//                {
//                    temp.right = new Node(k);
//                    return root;
//                }
//
//                if(temp.left != null) queue.add(node.left);
//                if(temp.right != null) queue.add(temp.right );
//
//            }
//
//            return root;
//
//        }
//
//
//        Are you there?


    }
}
