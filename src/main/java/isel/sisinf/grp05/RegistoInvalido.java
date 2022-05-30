package isel.sisinf.grp05;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

public class RegistoInvalido {
    private Integer id;
    private Integer latitude;
    private Integer longitude;
    private Integer id_gps;
    private Date data;

    public RegistoInvalido(Integer id, Integer latitude, Integer longitude, Integer id_gps, Date data){
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id_gps = id_gps;
        this.data = data;

    };

    public static void main(String[] args){
        RegistoInvalido ri = new RegistoInvalido(null, null, null, null, null);
        System.out.println(ri.id);
    }
}


