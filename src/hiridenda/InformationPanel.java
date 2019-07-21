/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hiridenda;

/**
 *
 * @author InAns
 */
public interface InformationPanel 
{
    void writeError(String text);
    void writeControl(String text);
    void writeClass(String text);
    void writeIndividual(String strClass, String text);
    void writeProperty(String text);
    void eraseTree();
}
