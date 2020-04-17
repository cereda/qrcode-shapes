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
package cereda.qrcode.shapes.writer.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.IOException;

/**
 * Gera uma imagem com código QR.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 * @since 1.0
 */
public class Generator {

    // arquivo de imagem a ser gerado
    private final File file;

    // largura da imagem
    private int width = 300;

    // altura da imagem
    private int height = 300;

    /**
     * Construtor.
     *
     * @param file Arquivo de imagem a ser gerado.
     */
    public Generator(File file) {
        this.file = file;
    }

    /**
     * Gera uma imagem com um código QR a partir do texto informado.
     *
     * @param text Texto a ser gerado o código QR.
     */
    public void generate(String text) {
        try {

            // define um escritor
            // de código QR
            QRCodeWriter w = new QRCodeWriter();

            // cria uma matriz de
            // bits de acordo com
            // o texto informado e
            // das dimensões da
            // imagem de saída
            BitMatrix m = w.encode(text, BarcodeFormat.QR_CODE, width, height);

            // escreve a matriz de
            // bits como uma imagem
            // PNG, de acordo com
            // as informações dadas
            MatrixToImageWriter.writeToPath(m, "PNG", file.toPath());

        } catch (IOException | WriterException exception) {

            // ocorreu uma exceção,
            // imprime mensagem
            System.err.println("Exceção: " + exception.getMessage());
        }
    }

    /**
     * Define a largura da imagem.
     *
     * @param width Largura da imagem.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Define a altura da imagem.
     *
     * @param height Altura da imagem.
     */
    public void setHeight(int height) {
        this.height = height;
    }

}
