using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BFF.Dto;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace BFF.Controllers
{
    [Route("api/[controller]")]
    public class BffOrdenesProductosController : Controller
    {
        // GET: api/values
        [HttpGet]
        public async Task<List<OrdenesProductosDto>> GetAsync()
        {
            string baseURL = "http://localhost:8080/";
            string url = baseURL + "ordenes-productos";
            using (HttpClient client = new HttpClient())
            {
                using (HttpResponseMessage responseMessage = await client.GetAsync(url))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<List<OrdenesProductosDto>>(response);
                    }
                }
            }
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/values
        [HttpPost]
        public async Task<OrdenesProductosResponseDto> PostAsync([FromBody] OrdenesProductosDto ordenProducto)
        {
            string baseURL = "http://localhost:8080/";
            string url = baseURL + "ordenes-productos";

            var json = JsonConvert.SerializeObject(ordenProducto);
            var data = new StringContent(json, System.Text.Encoding.UTF8, "application/json");

            using (HttpClient client = new HttpClient())
            {

                using (HttpResponseMessage responseMessage = await client.PostAsync(url, data))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<OrdenesProductosResponseDto>(response)!;
                    }
                }
            }
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public async Task<OrdenesProductosResponseDto> Put(int id, [FromBody] OrdenesProductosDto ordenProducto)
        {
            string baseURL = "http://localhost:8080/";
            string url = baseURL + "ordenes-productos";

            var json = JsonConvert.SerializeObject(ordenProducto);
            var data = new StringContent(json, System.Text.Encoding.UTF8, "application/json");

            using (HttpClient client = new HttpClient())
            {

                using (HttpResponseMessage responseMessage = await client.PutAsync(url, data))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<OrdenesProductosResponseDto>(response)!;
                    }
                }
            }
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public async Task<OrdenesProductosResponseDto> Delete(int id)
        {
            string baseURL = "http://localhost:8080/";
            string url = baseURL + "ordenes-productos" + "/" + id;


            using (HttpClient client = new HttpClient())
            {

                using (HttpResponseMessage responseMessage = await client.DeleteAsync(url))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<OrdenesProductosResponseDto>(response)!;
                    }
                }
            }
        }
    }
}

