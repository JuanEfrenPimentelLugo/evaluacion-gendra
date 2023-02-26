using System;
using System.Text.Json.Serialization;
using BFF.Dto;

namespace BFF.Servicios
{
	public class ClientesService: IClientesService
	{
		public ClientesService()
		{
		}

        bool IClientesService.actualizar(List<ClienteDto> clienteDto)
        {
            throw new NotImplementedException();
        }

        ClienteDto IClientesService.agregar(ClienteDto clienteDto)
        {
            throw new NotImplementedException();
        }

        bool IClientesService.eliminar(int idCliente)
        {
            throw new NotImplementedException();
        }

        List<ClienteDto> IClientesService.listar()
        {
            throw new NotImplementedException();
        }
    }
}

