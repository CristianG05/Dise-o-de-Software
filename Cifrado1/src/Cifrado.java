import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Cifrado {

    private int a, clave;
    private String cadena, encriptada, desencriptada;
    private String alfa[];

    public Cifrado(int a, String cadena, int clave) {
        this.clave = clave;
        this.a = a;
        this.cadena = cadena;
        alfa = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2",
            "3", "4", "5", "6", "7", "8", "9", " "};//38 caracteres
    }

    public ArrayList<Integer> MensajeNumeros(String mensaje) {

        ArrayList<Integer> mensaje_en_numeros = new ArrayList<>();

        for (int i = 0; i < mensaje.length(); i++) {

            for (int j = 0; j < alfa.length; j++) {

                if (alfa[j].charAt(0) == mensaje.charAt(i)) {

                    mensaje_en_numeros.add(j);
                }
            }
        }
        return mensaje_en_numeros;
    }

//    public String NumeroALetras(ArrayList<Integer> lista) {
//
//        String cifrado = "";
//
//        for (int i = 0; i < lista.size(); i++) {
//
//            cifrado = cifrado + alfa[lista.get(i) - 1];
//        }
//
//        return cifrado;
//    }
    public String NumeroALetras(ArrayList<Integer> Lista) {
        String aux = "";
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i) == 0) {
                aux = aux + "a";
            }
            if (Lista.get(i) == 1) {
                aux = aux + "b";
            }
            if (Lista.get(i) == 2) {
                aux = aux + "c";
            }
            if (Lista.get(i) == 3) {
                aux = aux + "d";
            }
            if (Lista.get(i) == 4) {
                aux = aux + "e";
            }
            if (Lista.get(i) == 5) {
                aux = aux + "f";
            }
            if (Lista.get(i) == 6) {
                aux = aux + "g";
            }
            if (Lista.get(i) == 7) {
                aux = aux + "h";
            }
            if (Lista.get(i) == 8) {
                aux = aux + "i";
            }
            if (Lista.get(i) == 9) {
                aux = aux + "j";
            }
            if (Lista.get(i) == 10) {
                aux = aux + "k";
            }
            if (Lista.get(i) == 11) {
                aux = aux + "l";
            }
            if (Lista.get(i) == 12) {
                aux = aux + "m";
            }
            if (Lista.get(i) == 13) {
                aux = aux + "n";
            }
            if (Lista.get(i) == 14) {
                aux = aux + "ñ";
            }
            if (Lista.get(i) == 15) {
                aux = aux + "o";
            }
            if (Lista.get(i) == 16) {
                aux = aux + "p";
            }
            if (Lista.get(i) == 17) {
                aux = aux + "q";
            }
            if (Lista.get(i) == 18) {
                aux = aux + "r";
            }
            if (Lista.get(i) == 19) {
                aux = aux + "s";
            }
            if (Lista.get(i) == 20) {
                aux = aux + "t";
            }
            if (Lista.get(i) == 21) {
                aux = aux + "u";
            }
            if (Lista.get(i) == 22) {
                aux = aux + "v";
            }
            if (Lista.get(i) == 23) {
                aux = aux + "w";
            }
            if (Lista.get(i) == 24) {
                aux = aux + "x";
            }
            if (Lista.get(i) == 25) {
                aux = aux + "y";
            }
            if (Lista.get(i) == 26) {
                aux = aux + "z";
            }
            if (Lista.get(i) == 27) {
                aux = aux + "0";
            }
            if (Lista.get(i) == 28) {
                aux = aux + "1";
            }
            if (Lista.get(i) == 29) {
                aux = aux + "2";
            }
            if (Lista.get(i) == 30) {
                aux = aux + "3";
            }
            if (Lista.get(i) == 31) {
                aux = aux + "4";
            }
            if (Lista.get(i) == 32) {
                aux = aux + "5";
            }
            if (Lista.get(i) == 33) {
                aux = aux + "6";
            }
            if (Lista.get(i) == 34) {
                aux = aux + "7";
            }
            if (Lista.get(i) == 35) {
                aux = aux + "8";
            }
            if (Lista.get(i) == 36) {
                aux = aux + "9";
            }
            if (Lista.get(i) == 37) {
                aux = aux + " ";
            }
        }
        return aux;
    }

    public void Encriptar() {

        ArrayList<Integer> listaMensaje = MensajeNumeros(cadena);
        ArrayList<Integer> numerosEncriptados = new ArrayList();

        for (int i = 0; i < listaMensaje.size(); i++) {

            int C = (a * listaMensaje.get(i) + clave) % 38;
            numerosEncriptados.add(C);
        }
        System.out.println("Encriptado: " + numerosEncriptados);
        encriptada = NumeroALetras(numerosEncriptados);
    }

    public void Desencriptar() {

        ArrayList<Integer> listaMensaje = MensajeNumeros(cadena);
        ArrayList<Integer> numeros_desencriptados = new ArrayList<>();

        HallarInverso inverso = new HallarInverso();
        long inv;
        int aux_num;
        inv = (long) inverso.CalcularInverso(a, 38);

        for (int i = 0; i < listaMensaje.size(); i++) {

            aux_num = (int) (inv * (listaMensaje.get(i) - clave)) % 38;

            if (aux_num < 0) {
                aux_num = aux_num + 38;
            }
            numeros_desencriptados.add(aux_num);
        }
        desencriptada = NumeroALetras(numeros_desencriptados);
    }

    public String GetMensajeCifrado() {
        return encriptada;
    }

    public String GetMensajeDescifrado() {
        return desencriptada;
    }

    public String CifraData(String data) {
        String encryptedData;//
        encryptedData = Cifrado(data);
        System.out.println(encryptedData);
        return encryptedData;
    }

    public String Cifrado(String dataACifrar) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(dataACifrar.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

}
