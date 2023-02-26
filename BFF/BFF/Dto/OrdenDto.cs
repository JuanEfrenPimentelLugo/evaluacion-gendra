using System;
namespace BFF.Dto
{
	public class OrdenDto
	{
		public OrdenDto()
		{
		}

		public int? idTOrdenes { get; set; }
		public DateOnly fecha { get; set; }
		public int idTClientes { get; set; }


    }
}

