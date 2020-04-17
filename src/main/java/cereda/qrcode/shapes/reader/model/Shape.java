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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Modelo de forma geométrica.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 */
public class Shape {

    // nome da forma
    private String name;

    // lista de variáveis
    private List<Variable> variables;

    // lista de fórmulas
    private List<Formula> formulas;

    /**
     * Construtor.
     *
     * @param name Nome da formna.
     * @param variables Lista de variáveis.
     * @param formulas Lista de fórmulas.
     */
    public Shape(String name, List<Variable> variables,
            List<Formula> formulas) {
        this.name = name;
        this.variables = variables;
        this.formulas = formulas;
    }

    /**
     * Construtor.
     */
    public Shape() {
    }

    /**
     * Obtém o nome da forma.
     *
     * @return Nome da forma.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da forma.
     *
     * @param name Nome da forma.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a lista de variáveis.
     *
     * @return Lista de variáveis.
     */
    public List<Variable> getVariables() {
        return variables;
    }

    /**
     * Define a lista de variáveis.
     *
     * @param variables Lista de variáveis.
     */
    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    /**
     * Obtém a lista de fórmulas.
     *
     * @return Lista de fórmulas.
     */
    public List<Formula> getFormulas() {
        return formulas;
    }

    /**
     * Define a lista de fórmulas.
     *
     * @param formulas Lista de fórmulas.
     */
    public void setFormulas(List<Formula> formulas) {
        this.formulas = formulas;
    }

    /**
     * Obtém a lista de nomes de fórmulas.
     *
     * @return Lista de nomes de fórmulas.
     */
    public List<String> getFormulaNames() {
        return formulas.stream().map(f -> f.getName()).
                collect(Collectors.toList());
    }

    /**
     * Obtém a fórmula pelo nome.
     *
     * @param name Nome da fórmula.
     * @return Fórmula correspondente.
     */
    public Formula getFormulaByName(String name) {
        return formulas.stream().filter(f -> f.getName().equals(name)).
                findFirst().get();
    }

    /**
     * Obtém o mapa de variáveis.
     *
     * @return Mapa de variáveis.
     */
    public Map<String, Double> getVariableMap() {
        return variables.stream().collect(Collectors.
                toMap(Variable::getVariable, Variable::getValue));
    }

}
