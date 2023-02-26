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
    public class BffProductosController : Controller
    {
        // GET: api/values
        [HttpGet]
        public async Task<List<ProductoDto>> GetAsync()
        {
            string baseURL = "http://localhost:8080/";
            string url = baseURL + "productos";
            using (HttpClient client = new HttpClient())
            {
                using (HttpResponseMessage responseMessage = await client.GetAsync(url))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<List<ProductoDto>>(response);
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
        public async Task<ProductosResponseDto> PostAsync([FromBody] ProductoDto producto)
        {
            string baseURL = "http://localhost:8080/";
            string url = baseURL + "productos";

            var json = JsonConvert.SerializeObject(producto);
            var data = new StringContent(json, System.Text.Encoding.UTF8, "application/json");

            using (HttpClient client = new HttpClient())
            {

                using (HttpResponseMessage responseMessage = await client.PostAsync(url, data))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<ProductosResponseDto>(response)!;
                    }
                }
            }
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public async Task<ProductosResponseDto> Put(int id, [FromBody] ProductoDto producto)
        {
            string baseURL = "http://localhost:8080/";
            string url = baseURL + "productos";

            var json = JsonConvert.SerializeObject(producto);
            var data = new StringContent(json, System.Text.Encoding.UTF8, "application/json");

            using (HttpClient client = new HttpClient())
            {

                using (HttpResponseMessage responseMessage = await client.PutAsync(url, data))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<ProductosResponseDto>(response)!;
                    }
                }
            }
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public async Task<ProductosResponseDto> Delete(int id)
        {
            string baseURL = "http://localhost:8080/";
            string url = baseURL + "productos" + "/" + id;


            using (HttpClient client = new HttpClient())
            {

                using (HttpResponseMessage responseMessage = await client.DeleteAsync(url))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<ProductosResponseDto>(response)!;
                    }
                }
            }
        }
    }
}

