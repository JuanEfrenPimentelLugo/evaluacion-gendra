using System;
namespace BFF.Dto
{
	public class ClienteResponseDto
	{
        public string? estatus { get; set; }
        public string? mensaje { get; set; }
        public ClienteDto? objeto  { get; set; }

        public ClienteResponseDto(string pEstatus, string pMensaje, ClienteDto pObjeto) {
            estatus = pEstatus;
            mensaje = pMensaje;
            objeto = pObjeto;
        }
    }
}

