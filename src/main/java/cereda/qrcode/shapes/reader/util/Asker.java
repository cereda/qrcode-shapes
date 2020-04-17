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

import cereda.qrcode.shapes.reader.model.Variable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 * Classe que realiza a consulta dos valores das variáveis.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 */
public class Asker {

    /**
     * Consulta o usuário sobre os valores das variáveis.
     *
     * @param variables Lista de variáveis.
     * @return Mapa com as variáveis.
     */
    public static Map<String, Double> ask(List<Variable> variables) {
        return variables.stream().collect(Collectors.toMap(
                Variable::getVariable,
                (Variable t) -> {

                    //tenta fazer a conversão
                    // de um valor textual
                    // para ponto flutuante
                    try {

                        // retorna a conversão de um
                        // valor textual para ponto
                        // flutuante de acordo com
                        // a interação com o usuário
                        return Double.parseDouble(JOptionPane.showInputDialog(
                                null, "Digite o valor para: " + t.getName(),
                                "Entrada de valores",
                                JOptionPane.INFORMATION_MESSAGE));

                    } catch (NumberFormatException
                    | NullPointerException exception) {

                        // ocorreu uma exceção na conversão,
                        // exibe a mensagem correspondente e
                        // retorna o valor padrão da variável
                        System.err.println("Exceção: "
                                + exception.getMessage());

                        // valor padrão da variável
                        // sendo analisada
                        return t.getValue();
                    }
                }
        ));
    }

    /**
     * Apresenta a lista de fórmulas.
     *
     * @param formulas Lista de fórmulas.
     * @return Fórmula escolhida.
     */
    public static String choose(List<String> formulas) {

        // obtém um vetor de opções
        // a partir da lista de
        // nomes de fórmulas
        Object[] options = formulas.toArray();

        // obtém qual fórmula calcular
        // a partir da interação com o
        // usuário do programa
        String input = (String) JOptionPane.showInputDialog(null,
                "Escolha qual fórmula calcular:", "Atenção!",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // retorna a fórmula a ser calculada
        // (ou a primeira opção, caso o usuário
        // não escolha nenhuma opção)
        return (input == null) ? (String) options[0] : input;
    }

}
