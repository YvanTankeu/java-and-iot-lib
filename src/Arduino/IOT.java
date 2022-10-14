/*
  Titre      : Utilisation de librairie
  Auteur     : Yvan Tankeu
  Date       : 03/10/2022
  Description: Librairie JSerialComm pour detecter
  Les Arduino connectés à notre ordinateur via l'USB
  Classe 	 :IOT
  Version    : 0.0.1
  Code de : https://www.youtube.com/watch?v=m4AyGmID4Eg&ab_channel=TikTikiLabs
*/

package Arduino;

import java.io.InputStream;
import com.fazecast.jSerialComm.*;

public class IOT {
    public static String devicePortName = "USB-SERIAL CH340";
    public static SerialPort arduinoPort = null;
    public static InputStream arduinoStream = null;
    public static int PACKET_SIZE_IN_BYTES = 8;

    public static void main(String[] args) {

        int len = SerialPort.getCommPorts().length;
        SerialPort serialPorts[] = new SerialPort[len];
        serialPorts = SerialPort.getCommPorts();

        for (int i = 0; i < len; i++) {

            String portName = serialPorts[i].getDescriptivePortName();
            System.out.println(serialPorts[i].getSystemPortName() + ": " + portName + ": " + i);

            if (portName.contains(devicePortName)) {
                arduinoPort = serialPorts[i];
                arduinoPort.openPort();
                System.out.println("connected to: " + portName + "[" + i + "]");
                break;
            }
        }

       /*PacketListener listener = new PacketListener();
        arduinoPort.addDataListener(listener);*/
    }
}
