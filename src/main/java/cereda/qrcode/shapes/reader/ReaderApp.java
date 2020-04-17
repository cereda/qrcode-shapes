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
package cereda.qrcode.shapes.reader;

import cereda.qrcode.shapes.Message;
import cereda.qrcode.shapes.reader.model.Shape;
import cereda.qrcode.shapes.reader.util.Asker;
import cereda.qrcode.shapes.reader.util.Calculator;
import cereda.qrcode.shapes.reader.util.FileDrop;
import cereda.qrcode.shapes.reader.util.Reader;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;

/**
 * Classe para leitura da imagem QR e cálculo das fórmulas correspondentes.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 */
public class ReaderApp extends JFrame {

    // painel para drag and drop
    // das imagens com código QR
    private final JLabel dropPanel;

    // caixa de combinação contendo
    // os dois modos de utilizaçã
    private final JComboBox mode;

    // rótulo que contém o resultado
    // da fórmula calculada
    private final JLabel result;

    /**
     * Construtor.
     */
    public ReaderApp() {

        // define o comportamento
        // da janela gráfica
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // define o gerenciador
        // de layout da interface
        setLayout(new MigLayout());

        // cria o painel de drag
        // and drop para a interface
        dropPanel = new JLabel();
        dropPanel.setIcon(new ImageIcon(ReaderApp.class.
                getResource("/cereda/qrcode/shapes/drop.png")));

        // cria a caixa de combinação
        // contendo os modos de utilização
        mode = new JComboBox();
        mode.addItem("Modo interativo");
        mode.addItem("Modo de consulta");

        // define algumas propriedades
        // da caixa de combinação
        mode.setEditable(false);
        mode.setFocusable(false);

        // define o rótulo de resultado
        // e inicialmente o mantém vazio,
        // sem referências textuais
        result = new JLabel(" ");

        // define uma nova área para
        // drag and drop de arquivos
        new FileDrop(dropPanel, (files) -> {

            // só é possível analisar uma
            // imagem por vez, caso contrário
            // torna-se confuso ao usuário
            if (files.length != 1) {

                // exibe mensagem de erro
                // referente ao número excessivo
                // de imagens para processar
                Message.message(JOptionPane.ERROR_MESSAGE,
                        "Não é possível analisar mais de uma imagem QR por "
                        + "vez. Por favor, escolha apenas uma imagem "
                        + "QR e tente novamemente."
                );

                // retorna o rótulo de resultado
                // ao estado original
                result.setText(" ");

            } else {

                // define um novo leitor de
                // imagem a partir da primeira
                // referência no vetor de arquivos
                Reader reader = new Reader(files[0]);

                // obtém a forma geométrica correspondente
                // do leitor de imagens QR e atribui a um
                // novo objeto de forma
                Shape shape = reader.get();

                // obtém o índice referente ao
                // modo de utilização selecionado
                int index = mode.getSelectedIndex();

                // obtém as variáveis de acordo com o
                // modo de utilização selecionado: se
                // estamos no modo interativo, os valores
                // são perguntados. No modo de consulta,
                // os valores definidos são utilizados.
                Map<String, Double> variables = index == 0
                        ? Asker.ask(shape.getVariables())
                        : shape.getVariableMap();

                // calcula o resultado a partir da fórmula escolhida
                // e de acordo com o valor do mapa de variáveis
                double c = Calculator.calculate(shape.getFormulaByName(
                        Asker.choose(shape.getFormulaNames())), variables);

                // define o texto no rótulo de
                // resultado, contendo o cáculo
                result.setText(String.format("Resultado: %2.2f", c));
            }

        });

        // adiciona o modo de utilização,
        // o painel drag and drop e o
        // rótulo de resultado
        add(mode, new CC().growX().flowX().wrap());
        add(dropPanel, new CC().wrap());
        add(result, new CC().growX().flowX());

        // empacota os componentes
        // para que suas dimensões
        // sejam configuradas
        pack();

        // define a posição da interface
        // na tela como centralizada
        setLocationRelativeTo(null);
    }

}
