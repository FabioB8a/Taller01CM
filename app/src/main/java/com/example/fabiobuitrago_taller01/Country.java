package com.example.fabiobuitrago_taller01;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *  Coded by: Fabio Luis Buitrago Ochoa
 */

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

    /**
     * Constructor to create a new Country object with provided details.
     *
     * @param name The name of the country.
     * @param nativeName The native name of the country.
     * @param code The alpha-3 code of the country.
     * @param currency The currency information of the country.
     * @param urlImage The URL of the country's flag image.
     * @param numericCode The numeric code of the country.
     * @param subRegion The subregion to which the country belongs.
     * @param latitude The latitude coordinate of the country.
     * @param longitude The longitude coordinate of the country.
     * @param nativeLanguage The native language spoken in the country.
     * @param area The area of the country.
     * @param alpha2Code The alpha-2 code of the country.
     * @param currencyCode The currency code of the country.
     */
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

    /**
     * Parcelable constructor to create a Country object from a Parcel.
     *
     * @param in The Parcel containing the data to construct the Country object.
     */
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


    /**
     * Describe the kinds of special objects contained in this Parcelable instance's marshaled representation.
     *
     * @return A bitmask indicating the set of special object types marshaled by this Parcelable object instance.
     */@Override
    public int describeContents() {
        return 0; // The implementation does not have any special objects, so 0 is returned.
    }

    /**
     * Write the object's data to the passed-in Parcel.
     *
     * @param dest  The Parcel to which the object's data should be written.
     * @param flags Flags indicating how the object should be written. This value is not used in the current implementation.
     */
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

    /**
     * A Creator implementation for generating instances of Country from a Parcel.
     */
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {

        /**
         * Create a new instance of the Parcelable class, instantiating it from the given Parcel.
         *
         * @param in The Parcel from which to re-create the Parcelable instance.
         * @return The newly created Country instance.
         */
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        /**
         * Create a new array of the Parcelable class.
         *
         * @param size The size of the array.
         * @return The new array of Country instances.
         */
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}
