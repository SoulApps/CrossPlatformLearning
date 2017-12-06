package alejandroSanchezGalvinFicheros;

import java.io.*;

/**
 * Created by Alejandro on 17/11/2016.
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
