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
package cereda.qrcode.shapes;

import cereda.qrcode.shapes.reader.ReaderApp;
import cereda.qrcode.shapes.writer.WriterApp;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Classe principal.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 * @since 1.0
 */
public class Main {

    /**
     * Método principal.
     *
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) {

        // instancia o objeto que implementa a
        // interface gráfica principal
        SwingUtilities.invokeLater(() -> {

            // tenta definir o tema da aplicação
            // antes de exibir a interface
            installTheme();

            // verifica se existe um argumento
            // para invocar a aplicação de escrita
            // que converte um arquivo YAML em uma
            // imagem QR correspondente
            if (args.length == 1 && "-w".equals(args[0])) {

                // invoca o método estático da classe de
                // gravação, permitindo converter um arquivo
                // YAML em uma imagem QR correspondente
                WriterApp.execute();

            } else {

                // cria a interface de
                // leitura e a torna visível
                new ReaderApp().setVisible(true);

            }
        });

    }

    /**
     * Instala o tema.
     */
    private static void installTheme() {
        try {

            // tenta definir o tema Nimbus como
            // o principal para a interface gráfica
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException exception) {

            // não foi possível definir o tema Nimbus como o
            // principal para a interface gráfica, imprime
            // mensagem de erro, mas continua mesmo assim
            System.err.println("Exceção: " + exception.getMessage());
        }
    }

}
