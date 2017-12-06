import java.lang.reflect.InvocationTargetException;

/**
 * Created by Alejandro on 15/04/2016.
 */
public class Main {
    public static void main(String[] args) {
        String value = "";

        //Invierte los botones del ratón. (El registro se cambia en el momento pero no funciona hasta que se reinicie)
        try {
            WinRegistry.writeStringValue(
                    WinRegistry.HKEY_CURRENT_USER,
                    "Control Panel\\Mouse",
                    "SwapMouseButtons", "1");
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        }
        System.out.println("Botones del mouse inviertidos");


        //Muestra la ruta de instalación de Acrobat Reader
        try {
            value = WinRegistry.readString(
                    WinRegistry.HKEY_LOCAL_MACHINE,
                    "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\App Paths\\AcroRd32.exe",
                    "");
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        }
        System.out.println("Ruta de Acrobat Reader = " + value);


        try {
            value = WinRegistry.readString(
                    WinRegistry.HKEY_LOCAL_MACHINE,
                    "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion", "ProductName");
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        }
        System.out.println("Versión de Windows = " + value.toString());
    }
}
