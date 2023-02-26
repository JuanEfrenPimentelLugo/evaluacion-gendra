using System;
namespace BFF.Dto
{
	public class OrdenesProductosDto
	{
		public OrdenesProductosDto()
		{
		}

		public int? idTOrdenProductos { get; set; }
        public int? cantidad { get; set; }
        public int? idTOrdenes { get; set; }
        public int? idTProductos { get; set; }

    }
}

