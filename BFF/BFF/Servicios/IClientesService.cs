using System;
using BFF.Dto;

namespace BFF.Servicios
{
	public interface IClientesService
	{
        public ClienteDto agregar(ClienteDto clienteDto);

        public List<ClienteDto> listar();

        public bool actualizar(List<ClienteDto> clienteDto);

        public bool eliminar(int idCliente);
    }
}

