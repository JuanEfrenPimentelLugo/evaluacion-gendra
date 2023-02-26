using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading.Tasks;
using BFF.Dto;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

    namespace BFF.Controllers
    {
        [Route("api/[controller]")]
        public class BffClientesController : Controller

        
        {
            // GET: api/values
            [HttpGet]
            public async Task<List<ClienteDto>> GetAsync()
            {
                string baseURL = "http://localhost:8080/";
                string url = baseURL + "clientes";
                using (HttpClient client = new HttpClient())
                {
                    using (HttpResponseMessage responseMessage = await client.GetAsync(url))
                    {
                        using (HttpContent content = responseMessage.Content)
                        {
                            string response = await content.ReadAsStringAsync();
                            return JsonConvert.DeserializeObject<List<ClienteDto>>(response);
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
            public async Task<ClienteResponseDto> PostAsync([FromBody]ClienteDto cliente)
            {
                string baseURL = "http://localhost:8080/";
                string url = baseURL + "clientes";

                var json = JsonConvert.SerializeObject(cliente);
                var data = new StringContent(json, System.Text.Encoding.UTF8, "application/json");

                using (HttpClient client = new HttpClient())
                {

                    using (HttpResponseMessage responseMessage = await client.PostAsync(url, data))
                    {
                        using (HttpContent content = responseMessage.Content)
                        {
                            string response = await content.ReadAsStringAsync();
                            return JsonConvert.DeserializeObject<ClienteResponseDto>(response)!;
                        }
                    }
                }
            }

            // PUT api/values/5
            [HttpPut("{id}")]
            public async Task<ClienteResponseDto> Put(int id, [FromBody] ClienteDto cliente)
            {
                string baseURL = "http://localhost:8080/";
                string url = baseURL + "clientes";

                var json = JsonConvert.SerializeObject(cliente);
                var data = new StringContent(json, System.Text.Encoding.UTF8, "application/json");

                using (HttpClient client = new HttpClient())
                {

                    using (HttpResponseMessage responseMessage = await client.PutAsync(url, data))
                    {
                        using (HttpContent content = responseMessage.Content)
                        {
                            string response = await content.ReadAsStringAsync();
                            return JsonConvert.DeserializeObject<ClienteResponseDto>(response)!;
                        }
                    }
                }
            }

            // DELETE api/values/5
            [HttpDelete("{id}")]
            public async Task<ClienteResponseDto> Delete(int id)
            {
                            string baseURL = "http://localhost:8080/";
                string url = baseURL + "clientes"+"/"+id;


                using (HttpClient client = new HttpClient())
                {

                using (HttpResponseMessage responseMessage = await client.DeleteAsync(url))
                {
                    using (HttpContent content = responseMessage.Content)
                    {
                        string response = await content.ReadAsStringAsync();
                        return JsonConvert.DeserializeObject<ClienteResponseDto>(response)!;
                    }
                }
                }
            }
        }
    }

