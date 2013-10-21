/*
 * Copyright (C) 2013 tckb < Chandra [dot] Tungathurthi [at] rwth-aachen.de >
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tckb.samples;
import com.tckb.audio.NonTrivialAudio;
import com.tckb.util.Utility;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tckb < Chandra [dot] Tungathurthi [at] rwth-aachen.de >
 */
public class NTAudioDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            File file = Utility.UI.getFile("Choose the audio file", null);
            NonTrivialAudio audio = new NonTrivialAudio(file);

            System.out.println(">>Audio header info");
            System.out.println(audio.getHeader());

            System.out.println(">>Playing first 10 secs of the audio file");

            double playTime = (audio.getDurationInSeconds() > 10 ? 10 : audio.getDurationInSeconds());
            audio.start();
            do{
                
                System.out.println("Play second: "+Utility.toFormatedTimeString((int) audio.getCurrentMS()));
                if(audio.getCurrentSecond()>=playTime){
                    audio.stop();
                    break;
                }
                Thread.sleep(1000);
                
            }while(true);
            
          
        } catch (Exception ex) {
            Logger.getLogger(NTAudioDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
