/**
 * Copyright 2020, Paulo Roberto Massa Cereda
 *
 * Licensed  under   the  Apache  License,  Version   2.0  (the
 * "License"); you may  not use this file  except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by  applicable law or agreed  to in writing,
 * software distributed under the  License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See  the License for the specific
 * language  governing permissions  and  limitations under  the
 * License.
 */
package cereda.qrcode.shapes.reader.util;

import cereda.qrcode.shapes.reader.model.Shape;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.yaml.snakeyaml.Yaml;

/**
 * Classe de leitura de um código QR.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 */
public class Reader {

    // arquivo da imagem
    private final File file;

    /**
     * Construtor.
     *
     * @param file Arquivo da imagem.
     */
    public Reader(File file) {
        this.file = file;
    }

    /**
     * Retorna um objeto de forma de acordo com a representação textual da
     * imagem em formato YAML.
     *
     * @return Um objeto de forma.
     */
    public Shape get() {
        try {

            // obtém a imagem a
            // partir do arquivo
            BufferedImage image = ImageIO.read(file);

            // obtém uma representação
            // matricial de acordo com
            // a luminosidade dos pixels
            LuminanceSource source = new BufferedImageLuminanceSource(image);

            // define uma representação
            // binária da imagem para
            // extração do texto
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // decodifica a matriz
            // binária correspondente
            Result result = new MultiFormatReader().decode(bitmap);

            // obtém a representação
            // textual da imagem
            String text = result.getText();

            // constrói o decodificador
            // do formato YAML
            Yaml yaml = new Yaml();

            // retorna a representação como objeto
            // da representação textual em YAML
            return yaml.loadAs(text, Shape.class);

        } catch (IOException | NotFoundException exception) {

            // ocorreu um erro, imprime
            // a exceção e retorna uma
            // referência nula
            System.err.println("Exceção: " + exception.getMessage());
            return null;
        }
    }

}
