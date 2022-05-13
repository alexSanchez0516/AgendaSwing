package ejercicio1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author xymind
 */
public class MiObjectOutputStream extends ObjectOutputStream {

    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    public MiObjectOutputStream() throws IOException, SecurityException {
        super();

    }

    /**
     * Redefinición del método de escribir la cabecera para que no haga nada.
     *
     * @throws java.io.IOException
     */
    @Override
    protected void writeStreamHeader() throws IOException {
    }

}
