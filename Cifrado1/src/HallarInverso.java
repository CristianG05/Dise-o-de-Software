
import javax.swing.JOptionPane;

public class HallarInverso {

    public double CalcularInverso(long n, long z) {
        
        long mcd[] = new long[3];
        int x = 0, y = 0;
        
        AlgoritmoEuclides obj = new AlgoritmoEuclides();
        
        if (n > z) {
            mcd = obj.euclidesExtendido(n, z);
        }
        if (n < z) {
            mcd = obj.euclidesExtendido(z, n);
        }        
        if (mcd[0] > 1) {
            
            JOptionPane.showMessageDialog(null, "El número clave debe ser primo", "Error!", JOptionPane.ERROR_MESSAGE);
            y = 0;
        } else {
            y = (int) mcd[2];
            if (y < 0) {
                y = (int) (y + z);
            }
        }        
        return y;
    }
}
