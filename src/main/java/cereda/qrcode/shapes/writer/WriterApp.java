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
package cereda.qrcode.shapes.writer;

import cereda.qrcode.shapes.Message;
import cereda.qrcode.shapes.writer.util.Generator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 * Classe de gravação de um arquivo YAML em uma imagem QR correspondente.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 * @since 1.0
 */
public class WriterApp {

    /**
     * Executa a gravação e conversão.
     */
    public static void execute() {

        // exibe a mensagem para
        // o arquivo de entrada
        String input = (String) JOptionPane.showInputDialog(null,
                Message.HTML("Digite o arquivo YAML de entrada. Este "
                        + "arquivo será convertido em uma imagem QR "
                        + "correspondente, em formato PNG."),
                "shape.yaml");

        // certifica-se que não
        // é uma referência nula
        input = input == null ? "shape.yaml" : input;

        // verifica se o arquivo
        // de entrada existe
        if (!new File(input).exists()) {

            // o arquivo de entrada não
            // existe, exibe mensagem de erro
            Message.message(JOptionPane.ERROR_MESSAGE, "O arquivo YAML "
                    + "informado não existe. É necessário fornecer um "
                    + "arquivo de entrada válido. Verifique se o caminho "
                    + "informado possui permissões de leitura e tente "
                    + "novamente.");

            // força a saída da
            // execução corrente
            System.exit(1);
        }

        String output = (String) JOptionPane.
                showInputDialog(null,
                        Message.HTML("Digite o arquivo PNG de saída. Este "
                                + "arquivo de imagem será gerado a partir da "
                                + "representação textual do arquivo YAML "
                                + "informado anteriormente."),
                        "shape.png");

        // certifica-se que não é uma
        // referência nula
        output = output == null ? "shape.png" : output;

        // cria um novo gerador
        // para o arquivo de saída
        Generator generator = new Generator(new File(output));

        try {

            // gera o arquivo de imagem QR
            // de acordo com o conteúdo do
            // arquivo YAML informado
            generator.generate(String.join("\n",
                    Files.readAllLines(Paths.get(input))));

            // exibe uma mensagem de sucesso
            // informando que a conversão
            // ocorreu com sucesso
            Message.message(JOptionPane.INFORMATION_MESSAGE,
                    "A conversão do arquivo YAML em uma imagem QR "
                    + "ocorreu com sucesso! Verifique a imagem QR "
                    + "gerada no programa de leitura.");

        } catch (IOException exception) {

            // ocorreu um erro, exibe
            // mensagem ao usuário
            System.err.println("Exceção: " + exception.getMessage());
        }
    }

}
