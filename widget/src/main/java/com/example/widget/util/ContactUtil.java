package com.example.widget.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;

import com.example.platform.contactlist.ContactEntry;
import com.example.widget.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arjen
 */

public class ContactUtil {
    //获取库Phon表字段
    private static final String[] PHONES_PROJECTION = new String[]{
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Photo.PHOTO_ID,
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
            ContactsContract.CommonDataKinds.Phone.NUMBER};
    // 联系人显示名称
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;
    //电话号码
    private static final int PHONES_NUMBER_INDEX = 1;
    //头像ID
    private static final int PHONES_PHOTO_ID_INDEX = 2;
    //联系人的ID
    private static final int PHONES_CONTACT_ID_INDEX = 3;

    public static List<ContactEntry> getContacts(Context context, boolean nullableBitMap) {
        if (nullableBitMap) {
            return getContacts(context);
        }

        List<ContactEntry> contactEntries = new ArrayList<>();
        for (ContactEntry contactEntry : getContacts(context)) {
            if (contactEntry.phoneBitMap != null) {
                contactEntries.add(contactEntry);
            }
        }
        return contactEntries;
    }

    public static List<ContactEntry> getContacts(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        final Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);

        List<ContactEntry> contactEntries = new ArrayList<>();
        ContactEntry contactEntry;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String contactName = cursor.getString(PHONES_DISPLAY_NAME_INDEX);
                String contactNum = cursor.getString(PHONES_NUMBER_INDEX);
                Long contactId = cursor.getLong(PHONES_CONTACT_ID_INDEX);
                Long photoId = cursor.getLong(PHONES_PHOTO_ID_INDEX);

                contactEntry = new ContactEntry();
                contactEntry.name = contactName;
                contactEntry.phone = contactNum;

                if (photoId > 0) {
                    Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId);
                    InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
                    contactEntry.phoneBitMap = BitmapFactory.decodeStream(inputStream);
                } else {
                    contactEntry.phoneBitMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_person_black_24dp);
                }
                contactEntries.add(contactEntry);
            }
        }

        return contactEntries;
    }
}
