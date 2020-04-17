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
 * Representa uma variável.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 * @since 1.0
 */
public class Variable {

    // nome da variável
    private String name;

    // representação da variável
    private String variable;

    // valor padrão da variável
    private double value;

    /**
     * Construtor.
     */
    public Variable() {
    }

    /**
     * Construtor.
     *
     * @param name Nome da variável.
     * @param variable Representação da variável.
     * @param value Valor padrão da variável.
     */
    public Variable(String name, String variable, double value) {
        this.name = name;
        this.variable = variable;
        this.value = value;
    }

    /**
     * Obtém o nome da variável.
     *
     * @return Nome da variável.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da variável.
     *
     * @param name Nome da variável.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a representação da variável.
     *
     * @return Representação da variável.
     */
    public String getVariable() {
        return variable;
    }

    /**
     * Define a representação da variável.
     *
     * @param variable Representação da variável.
     */
    public void setVariable(String variable) {
        this.variable = variable;
    }

    /**
     * Obtém o valor padrão da variável.
     *
     * @return Valor padrão da variável.
     */
    public double getValue() {
        return value;
    }

    /**
     * Define o valor padrão da variável.
     *
     * @param value Valor padrão da variável.
     */
    public void setValue(double value) {
        this.value = value;
    }

}
