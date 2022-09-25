/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageencrytion;

import static imageencrytion.TextE.cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.IllegalBlockingModeException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author hp
 */

public class ImageEncryption {
   KeyGenerator keyGenerator =null;
   SecretKey secretKey =null;
   Cipher cipher=null;
   
   public ImageEncryption(){
       try{
            keyGenerator = KeyGenerator.getInstance("AES");
            secretKey=keyGenerator.generateKey();
            cipher = Cipher.getInstance("AES");
       }
            catch(NoSuchPaddingException ex)
                    {
                      System.out.println(ex);
                    }
       catch(NoSuchAlgorithmException ex)
       {
                            System.out.println(ex);
                            
       }
      
       }

   public static void main(String[] args)
{
  String fileToEncrypt ="1.jpe";
  String encryptedFile="encryptedFile.jpg";
  String decryptedFile="decryptedFile.jpg";
  String directoryPath="C:/Temp/ImageEncryption/";
    ImageEncryption encryptFile=new ImageEncryption();
    
    System.out.println("Starting Encryption...");
    System.out.println("Encryption completed...");
    System.out.println("Starting decryption...");
    encryptFile.decrypt(directoryPath+encryptedFile,directoryPath+decryptedFile);
    System.out.println("decryption completed...");
    

    
}
 //  @param srcPath
   //@param destPath
           
           
 void encrypt (String srcPath, String destPath) 
 {
     File rawFile= new File(srcPath);
     File encryptedFile=new File(destPath);
     InputStream inStream=null;
     OutputStream outStream=null;
     try{
         
         cipher.init(Cipher.ENCRYPT_MODE,secretKey);
         inStream= new FileInputStream(rawFile);
         outStream=new FileOutputStream(encryptedFile);
         byte[] buffer =new byte[1024];
         int len;
         while((len=inStream.read(buffer))>0){
             outStream.write(cipher.update(buffer,0,len));
             outStream.flush();
             
         }
         outStream.write(cipher.doFinal());
         inStream.close();
         outStream.close();
         
         
     } catch(IllegalBlockSizeException ex)
     {
         System.out.println(ex);
     }
     catch(BadPaddingException ex)
     {
         System.out.println(ex);
         
     }
     catch(InvalidKeyException ex)
     {
         System.out.println(ex);
     }
     catch(FileNotFoundException ex)
     {
         System.out.println(ex);
         
     }
     catch(IOException ex)
     {
         System.out.println(ex);
     }
 
 }    
 
  void decrypt (String srcPath, String destPath) 
 {
     File decryptedFile= new File(destPath);
     File encryptedFile=new File(srcPath);
     InputStream inStream=null;
     OutputStream outStream=null;
     try{
         
         cipher.init(Cipher.DECRYPT_MODE,secretKey);
         inStream= new FileInputStream(encryptedFile);
         outStream=new FileOutputStream(decryptedFile);
         byte[] buffer =new byte[1024];
         int len;
         while((len=inStream.read(buffer))>0){
             outStream.write(cipher.update(buffer,0,len));
             outStream.flush();
             
         }
         outStream.write(cipher.doFinal());
         inStream.close();
         outStream.close();
         
         
     } catch(IllegalBlockSizeException ex)
     {
         System.out.println(ex);
     }
     catch(BadPaddingException ex)
     {
         System.out.println(ex);
         
     }
     catch(InvalidKeyException ex)
     {
         System.out.println(ex);
     }
     catch(FileNotFoundException ex)
     {
         System.out.println(ex);
         
     }
     catch(IOException ex)
     {
         System.out.println(ex);
     }
 
 }             
           
           
}