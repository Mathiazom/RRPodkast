package com.rrpm.mzom.projectrrpm.pod;

import android.os.Parcel;
import android.os.Parcelable;

import com.rrpm.mzom.projectrrpm.debugging.Assertions;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PodId implements Parcelable {


    private final String id;


    public PodId(final @NonNull String id){

        Assertions._assert(id != null , "Id string was null");

        this.id = id;
    }

    private PodId(Parcel source){

        Assertions._assert(source != null , "Source parcel was null");

        this.id = source.readString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o){

            return true;

        }

        if (o == null || getClass() != o.getClass()){

            return false;

        }

        final PodId podId = (PodId) o;

        return Objects.equals(id, podId.id);

    }

    @Override
    public int hashCode() {

        return Objects.hash(id);

    }


    public long uniqueLong(){

        final CharSequence subStringSequence = id.subSequence(21,id.length());

        final StringBuilder longStringBuilder = new StringBuilder();

        for(int i = 0; i < subStringSequence.length();i++){

            char c = subStringSequence.charAt(i);

            if(Character.isDigit(c)){

                longStringBuilder.append(c);

            }

        }

        String longString = longStringBuilder.toString();

        if(longString.length() > String.valueOf(Long.MAX_VALUE).length()){

            longString = longString.substring(0,String.valueOf(Long.MAX_VALUE).length()-1);

        }

        return Long.parseLong(longString);

    }


    @NonNull
    @Override
    public String toString() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        Assertions._assert(dest != null , "Destination parcel was null");

        dest.writeString(this.id);
    }

    public static final Creator<PodId> CREATOR = new Creator<PodId>() {
        @Override
        public PodId createFromParcel(Parcel source) {

            Assertions._assert(source != null , "Source parcel was null");

            return new PodId(source);
        }

        @Override
        public PodId[] newArray(int size) {
            return new PodId[size];
        }
    };
}
