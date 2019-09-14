package cr.ac.una.converters;


import cr.ac.una.beans.TipoMocionBean;
import cr.ac.una.entities.TipoMocion;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoMocionConverter")
public class TipoMocionConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String idTipoMocion) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{tipoMocionBean}", TipoMocionBean.class);

        TipoMocionBean tipoMociones = (TipoMocionBean) vex.getValue(ctx.getELContext());
        return tipoMociones.obtieneTipoMocion(Integer.valueOf(idTipoMocion));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object tipoMocion) {
        return ((TipoMocion)tipoMocion).toString();
    }
}
