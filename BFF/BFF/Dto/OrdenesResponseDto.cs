using System;
namespace BFF.Dto
{
	public class OrdenesResponseDto
	{
		public OrdenesResponseDto()
		{
		}

        public string? estatus { get; set; }
        public string? mensaje { get; set; }
        public OrdenDto? objeto { get; set; }

        public OrdenesResponseDto(string pEstatus, string pMensaje, OrdenDto pObjeto)
        {
            estatus = pEstatus;
            mensaje = pMensaje;
            objeto = pObjeto;
        }

    }
}

