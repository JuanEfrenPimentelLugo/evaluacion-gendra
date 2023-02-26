using System;
namespace BFF.Dto
{
	public class ClienteDto
	{
		public ClienteDto()
		{
		}

        public int? idTClientes { get; set; }
		public string? apellidoM { get; set; }
		public string? apellidoP { get; set; }
		public string? correo { get; set; }
		public string? nombre { get; set; }
		public string? telefono { get; set; }

	}
}

