package com.example.fabiobuitrago_taller01;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Country implements Parcelable {
    private String name;
    private String nativeName;
    private String code;
    private String currency;
    private String urlImage;
    private String numericCode;

    private String subRegion;
    private String latitude;
    private String longitude;
    private String nativeLanguage;
    private String area;
    private String alpha2Code;
    private String currencyCode;

    public Country(String name, String nativeName, String code, String currency, String urlImage, String numericCode, String subRegion, String latitude, String longitude, String nativeLanguage, String area, String alpha2Code, String currencyCode) {
        this.name = name;
        this.nativeName = nativeName;
        this.code = code;
        this.currency = currency;
        this.urlImage = urlImage;
        this.numericCode = numericCode;
        this.subRegion = subRegion;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nativeLanguage = nativeLanguage;
        this.area = area;
        this.alpha2Code = alpha2Code;
        this.currencyCode = currencyCode;
    }

    protected Country(Parcel in) {
        name = in.readString();
        nativeName = in.readString();
        code = in.readString();
        currency = in.readString();
        urlImage = in.readString();
        numericCode = in.readString();
        subRegion = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        nativeLanguage = in.readString();
        area = in.readString();
        alpha2Code = in.readString();
        currencyCode = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(nativeName);
        dest.writeString(code);
        dest.writeString(currency);
        dest.writeString(urlImage);
        dest.writeString(numericCode);
        dest.writeString(subRegion);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(nativeLanguage);
        dest.writeString(area);
        dest.writeString(alpha2Code);
        dest.writeString(currencyCode);
    }
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}
