using System;
namespace BFF.Dto
{
	public class OrdenesProductosResponseDto
	{
        public string? estatus { get; set; }
        public string? mensaje { get; set; }
        public OrdenesProductosDto? objeto { get; set; }

        public OrdenesProductosResponseDto(string pEstatus, string pMensaje, OrdenesProductosDto pObjeto)
        {
            estatus = pEstatus;
            mensaje = pMensaje;
            objeto = pObjeto;
        }
    }
}

