package es.saladillo.alejandro.practica02_alejandro;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Alejandro on 28/02/2017.
 */

// Tarea asíncrona que obtiene una foto a partir de su path y la muestra en un visor.
public class MostradorFotoAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private String sNombreArchivo; // Nombre para guardar en privado la foto escalada.

    private Context mContext;
    private ImageView mImgAlumno;

    public MostradorFotoAsyncTask(Context context, ImageView imgAlumno, String nombreArchivo) {
        super();
        mContext = context;
        mImgAlumno = imgAlumno;
        sNombreArchivo = nombreArchivo;
    }


    @Override
    protected Bitmap doInBackground(String... params) {
        // Se escala la foto, cuyo path corresponde al primer parámetro,
        // retornado el Bitmap correspondiente.
        return escalarFoto(params[0], mContext.getResources().getDimensionPixelSize(R.dimen.dimen_foto),
                mContext.getResources().getDimensionPixelSize(R.dimen.dimen_foto));
    }

    // Una vez finalizado el hilo de trabajo. Se ejecuta en el hilo
    // principal. Recibe el Bitmap de la foto escalada (o null si error).
    @Override
    protected void onPostExecute(Bitmap bitmapFoto) {
        if (bitmapFoto != null) {
            // Se guarda la copia propia de la imagen.
            File archivo = crearArchivoFoto(sNombreArchivo, false);
            if (archivo != null) {
                if (guardarBitmapEnArchivo(bitmapFoto, archivo)) {
                    // Se almacena el path de la foto a mostrar en el ImageView.
                    // Se muestra la foto en el ImageView.
                    mImgAlumno.setImageBitmap(bitmapFoto);
                }
            }
        }
    }


    // Agrega a la Galería la foto indicada.
    public void agregarFotoAGaleria(String pathFoto) {
        // Se crea un intent implícito con la acción de
        // escaneo de un fichero multimedia.
        Intent i = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        // Se obtiene la uri del archivo a partir de su path.
        File archivo = new File(pathFoto);
        Uri uri = Uri.fromFile(archivo);
        // Se establece la uri con datos del intent.
        i.setData(uri);
        // Se envía un broadcast con el intent.
        mContext.sendBroadcast(i);
    }

    public String getRealPath(Uri uriGaleria) {
        String path = "";
        // Se consulta en el content provider de la galería el path real del archivo de la foto.
        String[] filePath = {MediaStore.Images.Media.DATA};
        Cursor c = mContext.getContentResolver().query(uriGaleria, filePath, null, null, null);
        if (c != null && c.moveToFirst()) {
            int columnIndex = c.getColumnIndex(filePath[0]);
            path = c.getString(columnIndex);
            c.close();
        }
        return path;
    }

    public File crearArchivoFoto(String nombre, boolean publico) {
        // Se obtiene el directorio en el que almacenarlo.
        File directorio;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            if (publico) {
                // En el directorio público para imágenes del almacenamiento externo.
                directorio = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES);
            } else {
                directorio = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            }
        } else {
            // En almacenamiento interno.
            directorio = mContext.getFilesDir();
        }
        // Su no existe el directorio, se crea.
        if (directorio != null && !directorio.exists()) {
            if (!directorio.mkdirs()) {
                Log.d(mContext.getString(R.string.app_name), "error al crear el directorio");
                return null;
            }
        }
        // Se crea un archivo con ese nombre y la extensión jpg en ese
        // directorio.
        File archivo = null;
        if (directorio != null) {
            archivo = new File(directorio.getPath() + File.separator + nombre);
            Log.d(mContext.getString(R.string.app_name), archivo.getAbsolutePath());
        }
        // Se retorna el archivo creado.
        return archivo;
    }


    // Escala la foto indicada, para ser mostarda en un visor determinado.
    // Retorna el bitmap correspondiente a la imagen escalada o null si
    // se ha producido un error.
    private Bitmap escalarFoto(String pathFoto, int anchoVisor, int altoVisor) {
        try {
            // Se obtiene el tamaño de la imagen.
            BitmapFactory.Options opciones = new BitmapFactory.Options();
            opciones.inJustDecodeBounds = true; // Solo para cálculo.
            BitmapFactory.decodeFile(pathFoto, opciones);
            int anchoFoto = opciones.outWidth;
            int altoFoto = opciones.outHeight;
            // Se obtiene el factor de escalado para la imagen.
            int factorEscalado = Math.min(anchoFoto / anchoVisor, altoFoto / altoVisor);
            // Se escala la imagen con dicho factor de escalado.
            opciones.inJustDecodeBounds = false; // Se escalará.
            opciones.inSampleSize = factorEscalado;
            return BitmapFactory.decodeFile(pathFoto, opciones);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Guarda el bitamp de la foto en un archivo. Retorna si ha ido bien.
    private boolean guardarBitmapEnArchivo(Bitmap bitmapFoto, File archivo) {
        try {
            FileOutputStream flujoSalida = new FileOutputStream(archivo);
            bitmapFoto.compress(Bitmap.CompressFormat.JPEG, 100, flujoSalida);
            flujoSalida.flush();
            flujoSalida.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
