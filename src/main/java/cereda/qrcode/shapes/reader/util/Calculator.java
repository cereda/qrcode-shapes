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

import cereda.qrcode.shapes.reader.model.Formula;
import java.util.Map;
import org.mvel2.MVEL;

/**
 * Calculadora que obtém o cálculo da fórmula e o mapa de variáveis.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 */
public class Calculator {

    /**
     * Calcula a fórmula fornecida.
     *
     * @param formula Fórmula.
     * @param map Mapa de variáveis.
     * @return Valor calculado.
     */
    public static double calculate(Formula formula, Map<String, Double> map) {

        // calcula a fórmula através da representação
        // textual da fórmula e um mapa de variáveis
        // de ponto flutuante
        return (double) MVEL.eval(formula.getFormula(), map);
    }

}
