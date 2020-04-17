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
package cereda.qrcode.shapes.reader.model;

/**
 * Classe que representa uma fórmula da forma geométrica.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 * @since 1.0
 */
public class Formula {

    // nome da fórmula
    private String name;

    // valor da fórmula
    private String formula;

    /**
     * Construtor.
     */
    public Formula() {
    }

    /**
     * Construtor.
     *
     * @param name Nome da fórmula.
     * @param formula Valor da fórmula.
     */
    public Formula(String name, String formula) {
        this.name = name;
        this.formula = formula;
    }

    /**
     * Obtém o nome da fórmula.
     *
     * @return Nome da fórmula.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da fórmula.
     *
     * @param name Nome da fórmula.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o valor da fórmula.
     *
     * @return Valor da fórmula.
     */
    public String getFormula() {
        return formula;
    }

    /**
     * Define o valor da fórmula.
     *
     * @param formula Valor da fórmula.
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

}
