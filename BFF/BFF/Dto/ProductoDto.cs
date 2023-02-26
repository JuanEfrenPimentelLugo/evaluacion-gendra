using System;
namespace BFF.Dto
{
	public class ProductoDto
	{
		public ProductoDto()
		{
		}

        public int? idTProductos { get; set; }
        public string? nombre { get; set; }
        public decimal? precio { get; set; }

    }
}

