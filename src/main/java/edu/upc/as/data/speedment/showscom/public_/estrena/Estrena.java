package edu.upc.as.data.speedment.showscom.public_.estrena;

import com.speedment.Entity;
import edu.upc.as.data.speedment.showscom.public_.representacio.Representacio;

import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the
 * com.speedment.internal.ui.config.TableProperty@516db050.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public interface Estrena extends Entity<Estrena> {

    /**
     * Returns the nomlocal of this Estrena. The nomlocal field corresponds to
     * the database column showscom.public.estrena.nomlocal.
     *
     * @return the nomlocal of this Estrena
     */
    String getNomlocal();

    /**
     * Sets the nomlocal of this Estrena. The nomlocal field corresponds to the
     * database column showscom.public.estrena.nomlocal.
     *
     * @param nomlocal to set of this Estrena
     * @return this Estrena instance
     */
    Estrena setNomlocal(String nomlocal);

    /**
     * Returns the sessio of this Estrena. The sessio field corresponds to the
     * database column showscom.public.estrena.sessio.
     *
     * @return the sessio of this Estrena
     */
    String getSessio();
    
    /**
     * Sets the sessio of this Estrena. The sessio field corresponds to the
     * database column showscom.public.estrena.sessio.
     *
     * @param sessio to set of this Estrena
     * @return this Estrena instance
     */
    Estrena setSessio(String sessio);

    /**
     * Returns the recarrec of this Estrena. The recarrec field corresponds to
     * the database column showscom.public.estrena.recarrec.
     *
     * @return the recarrec of this Estrena
     */
    Integer getRecarrec();
    
    /**
     * Sets the recarrec of this Estrena. The recarrec field corresponds to the
     * database column showscom.public.estrena.recarrec.
     * 
     * @param recarrec to set of this Estrena
     * @return this Estrena instance
     */
    Estrena setRecarrec(Integer recarrec);
    
    /**
     * Finds and returns the foreign key Entity {@link Representacio} referenced
     * by the field that can be obtained using {@link Estrena#getNomlocal()}.<p>
     * N.B. The current implementation only supports lazy-loading of the
     * referenced Entities. This means that if you traverse N Estrena entities
     * and call this method for each one, there will be N SQL-queries executed.
     * 
     * @return the foreign key Entity {@link Representacio} referenced by the
     * field that can be obtained using {@link Estrena#getNomlocal()}
     */
    Representacio getRepresentacio();
}