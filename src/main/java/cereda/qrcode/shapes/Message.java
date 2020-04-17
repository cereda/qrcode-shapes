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

import javax.swing.JOptionPane;

/**
 * Classe utilitária que contém métodos para exibição e formatação de mensagens.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 * @since 1.0
 */
public class Message {

    /**
     * Exibe uma mensagem ao usuário.
     *
     * @param icon Valor inteiro que denota o ícone a ser exibido.
     * @param text Texto a ser exibido na tela.
     */
    public static void message(int icon, String text) {

        // exibe a mensagem ao usuário,
        // conforme o ícone o texto
        JOptionPane.showMessageDialog(null, HTML(text), "Atenção!", icon);
    }

    /**
     * Formata o texto como HTML para definir uma largura máxima.
     *
     * @param text Texto a ser formatado.
     * @return Texto já formatado como HTML.
     */
    public static String HTML(String text) {
        return String.format("<html><body><p style='width:"
                + " 250px;'>%s</p></body></html>", text);
    }

}
