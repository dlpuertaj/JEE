/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoapp;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author dlpuertaj
 */
public class PhotoAlbum {
    public static String ATRIBUTE_NAME = "Photo_Album";
    private List<byte[]> photoDataList = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    
    public static PhotoAlbum getPhotoAlbum(ServletContext servletContext){
        if(servletContext.getAttribute(ATRIBUTE_NAME) == null){
            PhotoAlbum pa = new PhotoAlbum();
            servletContext.setAttribute(ATRIBUTE_NAME, pa);
        }
        return (PhotoAlbum) servletContext.getAttribute(ATRIBUTE_NAME);
    }
    
    public synchronized void addPhoto(String name, byte[] bytes){
        this.photoDataList.add(bytes);
        this.names.add(name);
    }
    
    public synchronized byte[] getPhotoData(int i){
        return (byte[]) photoDataList.get(i);
    } 
    public synchronized String getPhotoName(int i){
        return (String) names.get(i);
    }
    public synchronized int getPhotoCount(){
        return photoDataList.size();
    }
    public synchronized void removePhoto(int i){
        photoDataList.remove(i);
        names.remove(i);
    }
}
