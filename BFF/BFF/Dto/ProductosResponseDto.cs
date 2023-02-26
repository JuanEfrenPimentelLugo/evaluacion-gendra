using System;
namespace BFF.Dto
{
	public class ProductosResponseDto
	{
		public ProductosResponseDto()
		{

		}

        public string? estatus { get; set; }
        public string? mensaje { get; set; }
        public ProductoDto? objeto { get; set; }

        public ProductosResponseDto(string pEstatus, string pMensaje, ProductoDto pObjeto)
        {
            estatus = pEstatus;
            mensaje = pMensaje;
            objeto = pObjeto;
        }
    }
}

