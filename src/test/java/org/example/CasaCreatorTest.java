package org.example;

import org.apache.commons.io.IOUtils;
import org.chilin.gsonbuilder.GoogleSerializer;
import org.chilin.model.Banio;
import org.chilin.model.Casa;
import org.chilin.model.Piso;
import org.chilin.model.Propietario;
import org.chilin.objectmapper.AndresitoSerializer;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CasaCreatorTest {

    private AndresitoSerializer serializer;
    private GoogleSerializer googleSerializer;

    @Test
    public void testCompleto() throws IOException, JSONException {

        this.serializer = new AndresitoSerializer();

        Casa miCasa = new Casa();
        miCasa.setPropietario(crearPropietario());
        miCasa.setDireccion("Calle 17BN No. 14-21");
        miCasa.setPisos(crearPisos());

        String serializedCasa = this.serializer.serializeCasa(miCasa);

        String expectedJson = IOUtils.toString(this.getClass().getResourceAsStream("/serialize/expectedcasa.json"),"UTF-8");

        JSONAssert.assertEquals(expectedJson, serializedCasa, JSONCompareMode.STRICT);
    }

    @Test
    public void testCompletoGoogle() throws IOException, JSONException {
        this.googleSerializer = new GoogleSerializer();

        Casa miCasa = new Casa();
        miCasa.setPropietario(crearPropietario());
        miCasa.setDireccion("Calle 17BN No. 14-21");
        miCasa.setPisos(crearPisos());

        String serializedCasa = this.googleSerializer.serializeCasaWithGoogle(miCasa);

        String expectedJson = IOUtils.toString(this.getClass().getResourceAsStream("/serialize/expectedcasa.json"),"UTF-8");

        JSONAssert.assertEquals(expectedJson, serializedCasa, JSONCompareMode.STRICT);
    }

    private Propietario crearPropietario(){
        Propietario propietario = new Propietario();
        propietario.setNombre("Andres");
        propietario.setApellido("Guerrero");
        return propietario;
    }

    private List<Piso> crearPisos(){
        List<Piso> pisos = new ArrayList<>();
        pisos.add(crearPrimerPiso());
        pisos.add(crearSegundoPiso());
        return pisos;
    }

    private Piso crearPrimerPiso(){
        Banio banioCaro = new Banio();
        banioCaro.setCantidadLavamanos(2);
        banioCaro.setCantidadDuchas(1);

        Banio miBanio = new Banio();
        miBanio.setCantidadLavamanos(1);
        miBanio.setCantidadDuchas(0);

        List<Banio> banios = new ArrayList<>();
        banios.add(banioCaro);
        banios.add(miBanio);

        Piso primerPiso = new Piso();
        primerPiso.setBanios(banios);
        primerPiso.setNombre("entrada");
        return primerPiso;
    }

    private Piso crearSegundoPiso(){
        List<Banio> banios = new ArrayList<>();

        Piso segundoPiso = new Piso();
        segundoPiso.setBanios(banios);
        segundoPiso.setNombre("");
        return segundoPiso;
    }

}
