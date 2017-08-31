
package com.lab.persistence.mapper;

import com.lab.persistence.mapper.bbdd.BBDD;
import com.lab.persistence.model.ItemModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
*/
@Repository
public class ItemMapperImpl implements ItemMapper
{
    @Autowired
    BBDD db;

    public List<ItemModel> searchMapper (ItemModel obj) throws Exception
    {
        //Creamos el array 'y' donde vamos a recoger los objetos
        List<ItemModel> y = new ArrayList<>();
        /**
        * CONECTANDO A LA BBDD.
        */
             db.conecta();
        
        //Realizamos consulta
        String sql= "SELECT * FROM items where (nombre LIKE '%"+obj.getNombre()+"%')";
        
        //Incluidmos en la variable rdo el resultado de la consulta
        ResultSet rdo=db.consulta(sql);
        
        //Recorremos la consulta
        while (rdo.next())
        {
            //Creamos los objetos 'item' para añadirlos al array 'y'
            ItemModel item = new ItemModel();
            
            //Obtenemos los resultados de  'rdo' y lo añadimos al objeto item a su propiedad
            item.setId(rdo.getInt("id"));
            item.setNombre(rdo.getString("nombre"));
            item.setDescripcion(rdo.getString("descripcion"));
            item.setUrl(rdo.getString("url"));
            
            //Añadimos al array 'y' cada objeto 'item' con sus propiedades obtenidas
            y.add(item);
            
        }
               
        //Desconectamos la BBDD
        db.desconecta();
        
        return y;
        
      
    }
}