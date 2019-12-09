package com.ihospital.utils;//import org.csource.fastdfs.*;
//
///**
// * @program: ihospital
// * @description:
// * @author: Mr.King
// * @create: 2019-11-20 20:29
// **/
//
//public class Test {
//    public static void main(String[] args) throws Exception {
//        ClientGlobal.init("D:\\IdeaProjects\\ihospital\\ihospital_utils\\src\\main\\resources\\fdfs_client.conf");
//        TrackerClient client=new TrackerClient();
//        TrackerServer trackerServer = client.getConnection();
//        StorageServer storageServer=null;
//        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
//        String[] strings =  storageClient.upload_file("C:\\Users\\15284\\Pictures\\a.jpg","jpg", null);
//        for (String str:strings){
//            System.out.println(str);
//        }
//    }
//
//
//}
