package com.android4dev.navigationview.Datamanagers;

/**
 * Created by ihebs on 07/05/2016.
 */


import android.media.Image;

import java.io.Serializable;

 public class Action implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String emailId;
     private Image pic ;

    public Action() {

    }
    public Action(String name, String emailId ) {
        this.name = name;
        this.emailId = emailId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


}