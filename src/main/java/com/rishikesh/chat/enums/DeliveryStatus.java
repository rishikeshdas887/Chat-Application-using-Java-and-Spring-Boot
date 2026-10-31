package com.rishikesh.chat.enums;

public enum DeliveryStatus {
    SENT,
    DELIVERED,
    READ


    //<-------------------------Getters------------------------------->
   public Long getId(){
    return id;
   }
   public Message getMessage(){
    return message;
   }
   public void setStatus(DeliveryStatus status){
    this.status=status;
   }
   public recipient getRecipient(){
    
   }


}
