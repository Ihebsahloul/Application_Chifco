package com.android4dev.navigationview.Datamanagers;

/**
 * Created by ihebs on 07/05/2016.
 */


import android.media.Image;

import java.io.Serializable;

 public class Action implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String Date;
     private String value ;
     private Image pic ;

    public Action() {

    }
    public Action(String name, String date ,String value ) {
        this.name = name;
        this.Date = date;
        this.value = value ;
      //  this.pic= pic  ;
    }

    public String getName() {
        return name;
    }
    // public Image getPic() {
     //    return pic;
    // }

    public void setName(String name) {
        this.name = name;
    }
    // public void setPic(Image pic) {
     //    this.pic = pic;
   //  }

     public String getValue() {
         return value;
     }

    public String getEmailId() {
        return Date;
    }

    public void setEmailId(String emailId) {
        this.Date = emailId;
    }
     public void setValue(String value) {
         this.value = value;
     }

}