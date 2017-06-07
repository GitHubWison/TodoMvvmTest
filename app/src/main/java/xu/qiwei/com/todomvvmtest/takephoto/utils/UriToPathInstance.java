package xu.qiwei.com.todomvvmtest.takephoto.utils;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

/**
 * Created by xuqiwei on 17-6-6.
 */

public class UriToPathInstance {
    private static Context mcontext;
    private static UriToPathInstance uriToPathInstance;

    public static UriToPathInstance getInstance(Context context) {
        if (uriToPathInstance == null) {
            synchronized (UriToPathInstance.class) {
                if (uriToPathInstance == null) {
                    uriToPathInstance = new UriToPathInstance(context);
                }
            }
        } else {
            mcontext = context;
        }
        return uriToPathInstance;
    }

    private UriToPathInstance(Context context) {
        mcontext = context;
    }

    public String handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();

        if (DocumentsContract.isDocumentUri(mcontext, uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                //Log.d(TAG, uri.toString());
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                //Log.d(TAG, uri.toString());
                Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),
                        Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            //Log.d(TAG, "content: " + uri.toString());
            imagePath = getImagePath(uri, null);
        }
        return imagePath;
    }

    public String getImagePath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = mcontext.getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }

            cursor.close();
        }
        return path;
    }
}
