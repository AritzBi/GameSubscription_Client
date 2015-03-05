

/**
 * GameService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.apache.ws.axis2;

    /*
     *  GameService java interface
     */

    public interface GameService {
          

        /**
          * Auto generated method signature
          * 
                    * @param insertGame0
                
         */

         
                     public org.apache.ws.axis2.InsertGameResponse insertGame(

                        org.apache.ws.axis2.InsertGame insertGame0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertGame0
            
          */
        public void startinsertGame(

            org.apache.ws.axis2.InsertGame insertGame0,

            final org.apache.ws.axis2.GameServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  main(
         org.apache.ws.axis2.Main main2

        ) throws java.rmi.RemoteException
        
        ;

        

        
       //
       }
    