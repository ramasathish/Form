package com.example.form;

import android.os.Parcel;
import android.os.Parcelable;

public class RegistrationEntity implements Parcelable {
    private String username=null;
    private String contactNo=null;
    private String emailId=null;
    private String gender=null;
    private String fordEmp=null;
    private String country=null;

    public String getUsername() {
        return username;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getGender() {
        return gender;
    }

    public String isFordEmp() {
        return fordEmp;
    }

    public String getCountry() {
        return country;
    }



    public RegistrationEntity(Parcel parcel) {
        username=parcel.readString();
        contactNo=parcel.readString();
        emailId=parcel.readString();
        gender=parcel.readString();
        fordEmp=parcel.readString();
        country=parcel.readString();

    }

    public RegistrationEntity(String username, String contactNo, String emailId, String gender, String fordEmp, String country) {
        this.username = username;
        this.contactNo = contactNo;
        this.emailId = emailId;
        this.gender = gender;
        this.fordEmp = fordEmp;
        this.country = country;
    }

    @Override
    public String toString() {
        return "RegistrationEntity{" +
                "username='" + username + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", emailId='" + emailId + '\'' +
                ", gender='" + gender + '\'' +
                ", fordEmp=" + fordEmp +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public void writeToParcel(Parcel dist, int flags){
        dist.writeString(username);
        dist.writeString(contactNo);
        dist.writeString(emailId);
        dist.writeString(gender);
        dist.writeString(fordEmp);
        dist.writeString(country);

    }
    @Override
    public int describeContents() {
        return 0;
    }


    public static final Parcelable.Creator<RegistrationEntity> CREATOR = new Parcelable.Creator<RegistrationEntity>(){
        public RegistrationEntity createFromParcel(Parcel in) {
            return new RegistrationEntity(in);
        }

        public RegistrationEntity[] newArray(int size) {
            return new RegistrationEntity[size];
        }
    };


}




